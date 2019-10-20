import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { map, startWith } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { NewsService } from '../news.service';
import { PortfolioConstruction } from '../portfolio.service';
import { PortfolioInterface } from '../PortfolioInterface';
import { Post } from '../models/Post';

@Component({
  selector: 'app-portfolios',
  templateUrl: './portfolios.component.html',
  styleUrls: ['./portfolios.component.css']
})

export class PortfoliosComponent implements OnInit {
 constructor(private portfoliosData : PortfolioConstruction,
  private authService: AuthService, private newsData : NewsService) { }
  
  isLoggedIn$: Observable<boolean>;  
  ticker : string;
  post : PortfolioInterface[];
  postNews : FinancialNewsInterface[];
  myControl = new FormControl();
  filteredOptions: Observable<string[]>;
  option : PortfolioInterface[]; 
 

 
  options: string[] = [
"ABT","ABBV","ABMD","ACN","ATVI","ADBE","AMD",
"AAP","AES","AMG","AFL","A","APD","AKAM","ALK",
"ALB","ARE","ALXN","ALGN","ALLE","AGN","ADS","LNT",
"ALL","GOOGL","GOOG","MO","AMZN","AMCR","AEE","AAL","AEP",
"AXP","AIG","AMT","AWK","AMP","ABC","AME","AMGN","APH","ADI",
"ANSS","ANTM","AON","AOS","APA","AIV","AAPL","AMAT","APTV","ADM",
"ARNC","ANET","AJG","AIZ","ATO","T","ADSK","ADP","AZO","AVB","AVY",
"BHGE","BLL","BAC","BK","BAX","BBT","BDX","BRK.B","BBY","BIIB","BLK",
"HRB","BA","BKNG","BWA","BXP","BSX","BMY","AVGO","BR","BF.B","CHRW",
"COG","CDNS","CPB","COF","CPRI","CAH","KMX","CCL","CAT","CBOE","CBRE",
"CBS","CDW","CE","CELG","CNC","CNP","CTL","CERN","CF","SCHW","CHTR","CVX",
"CMG","CB","CHD","CI","XEC","CINF","CTAS","CSCO","C","CFG","CTXS","CLX","CME",
"CMS","KO","CTSH","CL","CMCSA","CMA","CAG","CXO","COP","ED","STZ","COO","CPRT",
"GLW","CTVA","COST","COTY","CCI","CSX","CMI","CVS","DHI","DHR","DRI","DVA","DE",
"DAL","XRAY","DVN","FANG","DLR","DFS","DISCA","DISCK","DISH","DG","DLTR","D",
"DOV","DOW","DTE","DUK","DRE","DD","DXC","ETFC","EMN","ETN","EBAY","ECL",
"EIX","EW","EA","EMR","ETR","EOG","EFX","EQIX","EQR","ESS","EL","EVRG",
"ES","RE","EXC","EXPE","EXPD","EXR","XOM","FFIV","FB","FAST","FRT","FDX",
"FIS","FITB","FE","FRC","FISV","FLT","FLIR","FLS","FMC","F","FTNT",
"FTV","FBHS","FOXA","FOX","BEN","FCX","GPS","GRMN","IT","GD","GE",
"GIS","GM","GPC","GILD","GL","GPN","GS","GWW","HAL","HBI","HOG",
"HIG","HAS","HCA","HCP","HP","HSIC","HSY","HES","HPE","HLT","HFC",
"HOLX","HD","HON","HRL","HST","HPQ","HUM","HBAN","HII","IEX","IDXX",
"INFO","ITW","ILMN","IR","INTC","ICE","IBM","INCY","IP","IPG","IFF",
"INTU","ISRG","IVZ","IPGP","IQV","IRM","JKHY","JEC","JBHT","SJM","JNJ",
"JCI","JPM","JNPR","KSU","K","KEY","KEYS","KMB","KIM","KMI","KLAC","KSS",
"KHC","KR","LB","LHX","LH","LRCX","LW","LVS","LEG","LDOS","LEN","LLY","LNC",
"LIN","LKQ","LMT","L","LOW","LYB","MTB","MAC","M","MRO","MPC","MKTX","MAR",
"MMC","MLM","MAS","MA","MKC","MXIM","MCD","MCK","MDT","MRK","MET","MTD","MGM",
"MCHP","MU","MSFT","MAA","MHK","TAP","MDLZ","MNST","MCO","MS","MOS","MSI","MSCI",
"MYL","NDAQ","NOV","NTAP","NFLX","NWL","NEM","NWSA","NWS","NEE","NLSN","NKE","NI",
"NBL","JWN","NSC","NTRS","NOC","NCLH","NRG","NUE","NVDA","NVR","ORLY","OXY","OMC",
"OKE","ORCL","PCAR","PKG","PH","PAYX","PYPL","PNR","PBCT","PEP","PKI","PRGO",
"PFE","PM","PSX","PNW","PXD","PNC","PPG","PPL","PFG","PG","PGR","PLD",
"PRU","PEG","PSA","PHM","PVH","QRVO","PWR","QCOM","DGX","RL","RJF","RTN",
"O","REG","REGN","RF","RSG","RMD","RHI","ROK","ROL","ROP","ROST","RCL","CRM",
"SBAC","SLB","STX","SEE","SRE","SHW","SPG","SWKS","SLG","SNA","SO","LUV","SPGI",
"SWK","SBUX","STT","SYK","STI","SIVB","SYMC","SYF","SNPS","SYY","TMUS","TROW",
"TTWO","TPR","TGT","TEL","FTI","TFX","TXN","TXT","TMO","TIF","TWTR","TJX",
"TSCO","TDG","TRV","TRIP","TSN","UDR","ULTA","USB","UAA","UA","UNP","UAL",
"UNH","UPS","URI","UTX","UHS","UNM","VFC","VLO","VAR","VTR","VRSN","VRSK",
"VZ","VRTX","VIAB","V","VNO","VMC","WAB","WMT","WBA","DIS","WM","WAT","WEC",
"WCG","WFC","WELL","WDC","WU","WRK","WY","WHR","WMB","WLTW","WYNN","XEL","XRX",
"XLNX","XYL","YUM","ZBH","ZION","ZTS"
  ];
  

  ngOnInit() {  
    this.isLoggedIn$ = this.authService.isLoggedIn;
    
    this.portfoliosData.getPortfolios("SPY",["TLT","AAPL"]).subscribe(post => {
      this.post  = post;
    })

     this.newsData.getNews("SPY").subscribe(postNews => {
        this.postNews  = postNews;  })

        this.filteredOptions = this.myControl.valueChanges
        .pipe(startWith(''), map(value => this._filter(value)));

    }
  
    public _filter(value: string): string[] {
      const filterValue = value.toLowerCase();
  
      return this.options.filter(option => 
        option.toLowerCase().indexOf(filterValue) === 0);
    }

    public updatePortfolio(option){
        
      this.portfoliosData.getPortfolios("SPY",
      ["TLT","AAPL"].unshift(option)).subscribe(post => {
        this.post;
      })
      
       this.newsData.getNews(option).subscribe(postNews => {
          this.postNews  = postNews; 
        })
  
    }  

}