import { TestBed } from '@angular/core/testing';

import { CheckupRunnerService } from './checkup-runner.service';

describe('CheckupRunnerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CheckupRunnerService = TestBed.get(CheckupRunnerService);
    expect(service).toBeTruthy();
  });
});
