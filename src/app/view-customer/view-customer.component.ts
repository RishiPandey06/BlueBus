import { Component, OnInit } from '@angular/core';
import { ApiService } from "../api.service";
import { customer } from "../customer";
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {

  info: customer[] = [];

  constructor(private api: ApiService, private router: Router) { }

  async ngOnInit(): Promise<void> {
    let request = this.api.get_customer();
    const response = await request.toPromise();
    let i = 0;
    while (response[i] != null) {
      this.info.push(response[i]);
      i += 1
    }
  }

  edit(i: number) {
    this.router.navigate(['/add_customer'], { state: { data: this.info[i] } })
  }

  async delete(i: string): Promise<void> {
    let phone = (<HTMLTableCellElement>document.getElementById(i + "_phone")).innerHTML
    let request = this.api.delete_customer(phone);
    await request.toPromise() as Promise<void>;
    window.location.reload();
  }

}
