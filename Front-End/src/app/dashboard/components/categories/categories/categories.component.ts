import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../../../services/categories.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit {
  constructor(private service:CategoriesService){

  }


  cat=[
    {
      id:"",
      name:'',
      notes:'',
      status:'',
      date:''
    }
  
    
  ]
  ngOnInit(): void {
    this.service.getAllCategories().subscribe(res=>{
      this.cat = res;
      console.log(res)
    })

  }

}
