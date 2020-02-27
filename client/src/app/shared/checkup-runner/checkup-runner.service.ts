import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

export interface CollectionsCheckupConfigs {
  type: string;
  position: string;
  size: number;
  randomization: number;
  times: number;
}

@Injectable({
  providedIn: 'root'
})
export class CheckupRunnerService {

  constructor(private http: HttpClient) { }

  runCheckup(configs: CollectionsCheckupConfigs): Observable<CollectionsCheckupConfigs> {
	const httpOptions = {
	  headers: new HttpHeaders({
		'Access-Control-Allow-Origin': '*'
	})
	};
	return this.http.post<CollectionsCheckupConfigs>("//localhost:8080/run-collections-checkup", configs, httpOptions);
  }
}
