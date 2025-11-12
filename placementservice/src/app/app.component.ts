import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlacementService } from './placement.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Placement Management';
  placements: any[] = [];

  // Initialize editingPlacement with default values
  editingPlacement: any = {
    id: null,
    name: '',
    collegeId: '',
    qualification: '',
    year: null,
    date: ''
  };

  constructor(private placementService: PlacementService) {}

  ngOnInit(): void {
    this.loadPlacements();
  }

  // Load all placements from backend
  loadPlacements() {
    this.placementService.getPlacements().subscribe({
      next: (data) => this.placements = data,
      error: (err) => console.error('Error fetching placements:', err)
    });
  }

  // Add or update placement
  onRegister(form: NgForm) {
    if (!this.editingPlacement.id) {
  const { id, ...newPlacement } = this.editingPlacement; // remove id if present
  this.placementService.addPlacement(newPlacement).subscribe({
    next: () => { this.loadPlacements(); this.cancelEdit(form); },
    error: (err) => console.error('Error adding placement:', err)
  });
}
 else {
      // Add new placement
      this.placementService.addPlacement(this.editingPlacement).subscribe({
    next: () => {
        this.loadPlacements();
        this.cancelEdit(form);
    },
    error: (err) => console.error('Error adding placement:', err)
});

    }
  }

  // Load selected placement for editing
  editPlacement(placement: any) {
    // Clone object to avoid two-way binding issues
    this.editingPlacement = { ...placement };
  }

  // Delete placement
  deletePlacement(id: number) {
    if (confirm('Are you sure you want to delete this placement?')) {
      this.placementService.deletePlacement(id).subscribe({
        next: () => this.loadPlacements(),
        error: (err) => console.error('Error deleting placement:', err)
      });
    }
  }

  // Cancel editing/reset form
  cancelEdit(form?: NgForm) {
    this.editingPlacement = {
      id: null,
      name: '',
      collegeId: '',
      qualification: '',
      year: null,
      date: ''
    };
    if (form) form.resetForm();
  }
}
