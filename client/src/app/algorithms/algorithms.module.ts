import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatSortModule } from '@angular/material/sort';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatTabsModule } from '@angular/material/tabs';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatChipsModule } from '@angular/material/chips';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { AlgorithmsRoutingModule } from './algorithms-routing.module';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AlgorithmsComponent } from './algorithms.component';
import { AlgorithmsExecutionSummaryTableComponent } from './algorithms-execution-summary-table/algorithms-execution-summary-table.component';
import { CollectionsCheckupRunnerComponent } from './collections-checkup-runner/collections-checkup-runner.component';

@NgModule({
  declarations: [AlgorithmsComponent, AlgorithmsExecutionSummaryTableComponent, CollectionsCheckupRunnerComponent],
  imports: [
    CommonModule,
    AlgorithmsRoutingModule,
	MatTableModule,
	MatSortModule,
	MatInputModule,
	MatButtonModule,
	MatCardModule,
	MatTabsModule,
	MatStepperModule,
	MatGridListModule,
	MatSelectModule,
	MatFormFieldModule,
	MatListModule,
	MatDividerModule,
	MatChipsModule,
	MatProgressBarModule,
	FormsModule,
	ReactiveFormsModule,
  ]
})
export class AlgorithmsModule { }
