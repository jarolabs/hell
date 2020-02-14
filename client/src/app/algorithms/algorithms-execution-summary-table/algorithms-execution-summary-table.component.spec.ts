import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlgorithmsExecutionSummaryTableComponent } from './algorithms-execution-summary-table.component';

describe('AlgorithmsExecutionSummaryTableComponent', () => {
  let component: AlgorithmsExecutionSummaryTableComponent;
  let fixture: ComponentFixture<AlgorithmsExecutionSummaryTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlgorithmsExecutionSummaryTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlgorithmsExecutionSummaryTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
