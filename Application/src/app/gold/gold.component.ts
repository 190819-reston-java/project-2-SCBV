import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'
import { NewsService } from '../news.service';
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { AuthService } from '../auth/auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  constructor(private pricingData : PricingDataService, private newsData : NewsService,private authService: AuthService) { }
  
  isLoggedIn$: Observable<boolean>; 
  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() {   
    this.isLoggedIn$ = this.authService.isLoggedIn;
    this.pricingData.getPrices("GLD").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("GLD").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
  }


