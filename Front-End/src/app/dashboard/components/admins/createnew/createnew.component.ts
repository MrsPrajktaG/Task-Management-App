import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { StorageService } from '../../../../auth/storage/storage.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { from } from 'rxjs';

@Component({
  selector: 'app-createnew',
  templateUrl: './createnew.component.html',
  styleUrl: './createnew.component.css'
})
export class CreatenewComponent implements OnInit {
  constructor(private service:AdminService,private storage:StorageService,router:Router){}

  group = [
    {
      id : "",
      group_name : "",
      Created_date : "",
      description : "",
    }
  ]

  ngOnInit(): void {
    this.service.getAllGroups().subscribe(res=>{
      if(res!==null){
        this.group = res;
      }
    }, err=>{
      console.log(err);
      
    })
  }


     
  form: FormGroup =new FormGroup({
    firstname:new FormControl(''),
    lastname:new FormControl(''),
    email:new FormControl(''),
    password:new FormControl(''),
    phone:new FormControl(''),
    address:new FormControl(''),
    image:new FormControl(''),
    group:new FormControl('')
  })

  user = {
    firstname: "",
    lastname: "",
    email: "",
    password: "",
    phone: "",
    address: "",
    image: "",
    adminGroups : {
      id : ""
    }
  }

  FormSubmit(){
    this.user.firstname = this.form.get("firstname")?.value,
    this.user.lastname = this.form.get("lastname")?.value,
    this.user.email = this.form.get("email")?.value,
    this.user.password = this.form.get("password")?.value,
    this.user.phone = this.form.get("phone")?.value,
    this.user.address = this.form.get("address")?.value,
    this.user.image = this.form.get("image")?.value,
    this.user.adminGroups.id = this.form.get("group")?.value,
    

    this.service.adduser(this.user).subscribe(res=>{
      if(res!==null){
        console.log(res);
        
        
      }
    },err=>{
      console.log(err);

      // this.router.navigate(['/admins'])
      
    })

  }

  }


