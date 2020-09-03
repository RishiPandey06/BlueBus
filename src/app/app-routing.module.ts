import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCustomerComponent } from "./add-customer/add-customer.component";
import { HomeComponent } from "./home/home.component";
import { ViewCustomerComponent } from "./view-customer/view-customer.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'add_customer', component: AddCustomerComponent },
  { path: 'view_customer', component: ViewCustomerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
