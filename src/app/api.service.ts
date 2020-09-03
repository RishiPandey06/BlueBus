import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  public getCities() {
    return this.httpClient.get("http://localhost:8080/getCity");
  }

  public getLocations(city: string) {
    let params = new HttpParams();
    params = params.append("city", city);
    return this.httpClient.get("http://localhost:8080/getLocation", { params: params });
  }

  public insert_customer(name: string, phone: string, email: string,
    gender: string, fromLoc: string, toLoc: string, fromPick: string, toPick: string) {
    let params = new HttpParams();
    params = params.append("name", name);
    params = params.append("phone", phone);
    params = params.append("email", email);
    params = params.append("gender", gender);
    params = params.append("fromLoc", fromLoc);
    params = params.append("toLoc", toLoc);
    params = params.append("fromPick", fromPick);
    params = params.append("toPick", toPick);

    return this.httpClient.get("http://localhost:8080/insertCustomers", { params: params });
  }

  public get_customer() {
    return this.httpClient.get("http://localhost:8080/getCustomers");
  }

  public edit_customer(name: string, phone: string, email: string,
    gender: string, fromLoc: string, toLoc: string, fromPick: string, toPick: string) {
    let params = new HttpParams();
    params = params.append("name", name);
    params = params.append("phone", phone);
    params = params.append("email", email);
    params = params.append("gender", gender);
    params = params.append("fromLoc", fromLoc);
    params = params.append("toLoc", toLoc);
    params = params.append("fromPick", fromPick);
    params = params.append("toPick", toPick);
    return this.httpClient.get("http://localhost:8080/editCustomer", { params: params });
  }
  public delete_customer(phone: string) {
    let params = new HttpParams();
    params = params.append("phone", phone);
    return this.httpClient.get("http://localhost:8080/deleteCustomer", { params: params });
  }
}
