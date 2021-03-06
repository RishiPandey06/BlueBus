import { Component, OnInit } from '@angular/core';
import { ApiService } from "../api.service";
import { customer } from "../customer";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  cities: string[] = [];
  locations_to: string[] = [];
  locations_from: string[] = [];
  data: customer = history.state.data;

  constructor(private api: ApiService) { }

  async ngOnInit(): Promise<void> {
    let request = this.api.getCities();
    const response = await request.toPromise();
    let i = 0;
    while (response[i] != null) {
      if (this.cities.indexOf(response[i]) === -1) {
        this.cities.push(response[i]);
      }
      i += 1;
    }
    if (this.data !== undefined) {
      (<HTMLInputElement>document.getElementById("name")).value = this.data.name;
      (<HTMLInputElement>document.getElementById("num")).value = this.data.phone;
      (<HTMLInputElement>document.getElementById("num")).disabled = true;
      (<HTMLInputElement>document.getElementById("email")).value = this.data.email;
      let gender = this.data.gender;
      if (gender == 0) {
        (<HTMLInputElement>document.getElementById("female")).checked = true;
      }
      else {
        (<HTMLInputElement>document.getElementById("male")).checked = true;
      }
      (<HTMLButtonElement>document.getElementById("add")).innerHTML = "Update";
    }
  }

  async sel_to(): Promise<void> {
    let tcity: string = (<HTMLSelectElement>document.getElementById("tCity")).value;
    let request1 = this.api.getLocations(tcity);
    const response1 = await request1.toPromise();
    let j = 0;
    while (response1[j] != null) {
      this.locations_to.push(response1[j]);
      j += 1;
    }
  }

  async sel_from(): Promise<void> {
    let fcity: string = (<HTMLSelectElement>document.getElementById("fCity")).value;
    let request1 = this.api.getLocations(fcity);
    const response1 = await request1.toPromise();
    let j = 0;
    while (response1[j] != null) {
      this.locations_from.push(response1[j]);
      j += 1;
    }
  }

  async add_customer(): Promise<void> {
    let name = (<HTMLInputElement>document.getElementById("name")).value;
    let num = (<HTMLInputElement>document.getElementById("num")).value;
    let email = (<HTMLInputElement>document.getElementById("email")).value;
    let gender: number = 1;
    if ((<HTMLInputElement>document.getElementById("female")).checked) {
      gender = 2;
    }
    let f_city = (<HTMLSelectElement>document.getElementById("fCity")).value
    let t_city = (<HTMLSelectElement>document.getElementById("tCity")).value
    let f_loc = (<HTMLSelectElement>document.getElementById("fLoc")).value
    let t_loc = (<HTMLSelectElement>document.getElementById("tLoc")).value

    if ((<HTMLButtonElement>document.getElementById("add")).innerHTML == "Submit") {
      let request = this.api.insert_customer(name, num, email, gender.toString(), f_city, t_city, f_loc, t_loc);
      await request.toPromise() as Promise<void>;
    }
    else {
      let request = this.api.edit_customer(name, num, email, gender.toString(), f_city, t_city, f_loc, t_loc);
      await request.toPromise() as Promise<void>;
    }
  }
}
