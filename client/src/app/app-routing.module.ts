import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
	{ 
		path: 'algorithms',
		loadChildren: () => import('./algorithms/algorithms.module').then(m => m.AlgorithmsModule)
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
