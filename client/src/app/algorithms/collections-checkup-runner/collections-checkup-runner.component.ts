import { Component, OnInit } from '@angular/core';
import { CheckupRunnerService, CollectionsCheckupConfigs } from 'src/app/shared/checkup-runner/checkup-runner.service';
import { FormControl } from '@angular/forms';

export interface ExecutionProgress {
  mode: 'determinate' | 'indeterminate' | 'buffer' | 'query';
  progress: number
}

@Component({
  selector: 'app-collections-checkup-runner',
  templateUrl: './collections-checkup-runner.component.html',
  styleUrls: ['./collections-checkup-runner.component.css']
})
export class CollectionsCheckupRunnerComponent implements OnInit {
  public selectedType = new FormControl();
  public selectedPosition = new FormControl();
  public sizeInputValue = new FormControl();
  public randomizationInputValue = new FormControl();
  public times = new FormControl();

  public types = [
	{value: 'array_list', viewValue: 'Array List'},
	{value: 'linked_list', viewValue: 'Linked List'},
  ];

  public positions = [
	{value: 'beginning', viewValue: 'Beginning'},
	{value: 'middle', viewValue: 'Middle'},
	{value: 'end', viewValue: 'End'},
  ];

  public executionQueue: ExecutionProgress[] = [
	{ mode: 'buffer', progress: 0 },
	{ mode: 'buffer', progress: 80 }
  ]

  constructor(private service: CheckupRunnerService) { }

  ngOnInit() {}

  runCheckup() {
	const configs: CollectionsCheckupConfigs = {
	  type: this.selectedType.value,
	  position: this.selectedPosition.value,
	  size: this.sizeInputValue.value,
	  randomization: this.randomizationInputValue.value,
	}
	this.service.runCheckup(configs).subscribe();
  }
}
