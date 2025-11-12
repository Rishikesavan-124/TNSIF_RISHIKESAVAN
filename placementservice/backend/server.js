const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const { Pool } = require('pg'); // ✅ PostgreSQL import

const app = express();
const port = process.env.PORT || 8080;

app.use(cors());
app.use(bodyParser.json());

// Fallback data (in case DB fails)
let fallbackPlacements = [
  { id: 1, name: 'John Doe', collegeId: 'C001', qualification: 'B.Tech', year: 2023, date: '2024-01-15' }
];
let nextId = 2;
let useDb = false;

// PostgreSQL Connection Pool
const pool = new Pool({
  host: process.env.DB_HOST || 'localhost',
  user: process.env.DB_USER || 'postgres',
  password: process.env.DB_PASSWORD || 'rishi',  // 🔑 update your password
  database: process.env.DB_NAME || 'PMS',
  port: process.env.DB_PORT || 5432
});

// Test connection
pool.connect()
  .then(client => {
    console.log('✓ PostgreSQL connected successfully to "pm"');
    useDb = true;
    client.release();
  })
  .catch(err => {
    console.error('✗ PostgreSQL connection failed:', err.message);
    console.log('Using fallback in-memory data store...');
    useDb = false;
  });

// ---- Endpoints ----

// GET all placements
app.get('/placements', async (req, res) => {
  try {
    if (!useDb) return res.json(fallbackPlacements);
    const { rows } = await pool.query('SELECT * FROM placements');
    res.json(rows);
  } catch (err) {
    console.error('Error fetching placements:', err.message);
    res.json(fallbackPlacements);
  }
});

// GET placement by ID
app.get('/placements/:id', async (req, res) => {
  const id = parseInt(req.params.id);
  try {
    if (!useDb) {
      const placement = fallbackPlacements.find(p => p.id === id);
      if (!placement) return res.status(404).json({ error: 'Placement not found' });
      return res.json(placement);
    }
    const { rows } = await pool.query('SELECT * FROM placements WHERE id = $1', [id]);
    if (rows.length === 0) return res.status(404).json({ error: 'Placement not found' });
    res.json(rows[0]);
  } catch (err) {
    console.error('Error fetching placement:', err.message);
    res.status(500).json({ error: 'Failed to fetch placement' });
  }
});

// POST new placement
app.post('/placements', async (req, res) => {
  const { name, collegeId, qualification, year, date } = req.body;
  if (!name || !collegeId || !qualification || !year || !date)
    return res.status(400).json({ error: 'All fields are required' });

  try {
    if (!useDb) {
      const newPlacement = { id: nextId++, name, collegeId, qualification, year, date };
      fallbackPlacements.push(newPlacement);
      return res.status(201).json(newPlacement);
    }
    const query = `
      INSERT INTO placements (name, collegeId, qualification, year, date)
      VALUES ($1, $2, $3, $4, $5)
      RETURNING *;
    `;
    const { rows } = await pool.query(query, [name, collegeId, qualification, year, date]);
    res.status(201).json(rows[0]);
  } catch (err) {
    console.error('Error adding placement:', err.message);
    res.status(500).json({ error: 'Failed to add placement' });
  }
});

// PUT update placement
app.put('/placements/:id', async (req, res) => {
  const id = parseInt(req.params.id);
  const { name, collegeId, qualification, year, date } = req.body;
  if (!name || !collegeId || !qualification || !year || !date)
    return res.status(400).json({ error: 'All fields are required' });

  try {
    const query = `
      UPDATE placements
      SET name = $1, collegeId = $2, qualification = $3, year = $4, date = $5
      WHERE id = $6
      RETURNING *;
    `;
    const { rows } = await pool.query(query, [name, collegeId, qualification, year, date, id]);
    if (rows.length === 0) return res.status(404).json({ error: 'Placement not found' });
    res.json(rows[0]);
  } catch (err) {
    console.error('Error updating placement:', err.message);
    res.status(500).json({ error: 'Failed to update placement' });
  }
});

// DELETE placement
app.delete('/placements/:id', async (req, res) => {
  const id = parseInt(req.params.id);
  try {
    const { rowCount } = await pool.query('DELETE FROM placements WHERE id = $1', [id]);
    if (rowCount === 0) return res.status(404).json({ error: 'Placement not found' });
    res.json({ message: 'Placement deleted successfully' });
  } catch (err) {
    console.error('Error deleting placement:', err.message);
    res.status(500).json({ error: 'Failed to delete placement' });
  }
});

// Start server
app.listen(port, () => {
  console.log(`🚀 Backend running on http://localhost:${port}`);
  console.log('Database: pm (PostgreSQL)');
  console.log('Table: placements');
});
