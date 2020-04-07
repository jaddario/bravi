import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OpenweatherService {

  constructor(private http: HttpClient) { }

  getWeather(location){
    return this.http.get(
      'https://api.openweathermap.org/data/2.5/weather?q='+location+
      '&units=metric&appid={USER_KEY}'
    )
  }
}
