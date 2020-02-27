import { Component, OnInit, ViewChild } from '@angular/core';
import { SummaryReportService, ExecutionSummary } from 'src/app/shared/summary-report/summary-report.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-algorithms-execution-summary-table',
  templateUrl: './algorithms-execution-summary-table.component.html',
  styleUrls: ['./algorithms-execution-summary-table.component.css']
})
export class AlgorithmsExecutionSummaryTableComponent implements OnInit {
  displayedColumns: string[] = [
	'type',
	'position',
	'size',
	'randomization',
	'genTime',
	'sortTime',
	'addTime',
	'deleteTime',
	'findTime',
	'measure',
  ];
  dataSource: MatTableDataSource<ExecutionSummary>;

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private reportService: SummaryReportService) {}

  ngOnInit() {
    this.reportService.load().subscribe(response => {
      this.dataSource = new MatTableDataSource<ExecutionSummary>(response);
      this.dataSource.sort = this.sort;
    })
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  clear() {
	this.reportService.clear();
  }
}
