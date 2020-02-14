import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

export interface ExecutionSummary {
  type: string;
  position: string;
  size: number;
  randomization: number;
  genTime: number;
  sortTime: number;
  addTime: number;
  deleteTime: number;
  findTime: number;
  timeMeasure: string;
}

@Injectable({
  providedIn: 'root'
})
export class SummaryReportService {

  constructor(private http: HttpClient) { }

  load(): Observable<ExecutionSummary[]> {
    return this.http.get<ExecutionSummary[]>("//localhost:8080/show-report")
  }
}
