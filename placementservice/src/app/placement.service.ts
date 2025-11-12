import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlacementService {
  private baseUrl = 'http://localhost:8080/placements';

  constructor(private http: HttpClient) {}

  // Get all placements
  getPlacements(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  // Get placement by ID
  getPlacement(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // Add new placement
  addPlacement(placement: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}`, placement);
  }

  // Update placement
  updatePlacement(id: number, placement: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${id}`, placement);
  }

  // Delete placement
  deletePlacement(id: number): Observable<any> {
    // Return JSON object instead of plain text for consistency
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }
}
