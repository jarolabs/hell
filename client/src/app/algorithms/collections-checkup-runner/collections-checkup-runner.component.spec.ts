import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectionsCheckupRunnerComponent } from './collections-checkup-runner.component';

describe('CollectionsCheckupRunnerComponent', () => {
  let component: CollectionsCheckupRunnerComponent;
  let fixture: ComponentFixture<CollectionsCheckupRunnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollectionsCheckupRunnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectionsCheckupRunnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
