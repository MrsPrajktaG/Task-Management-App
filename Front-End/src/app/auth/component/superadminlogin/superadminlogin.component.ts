import { Component } from '@angular/core';



import { Router } from '@angular/router';

import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../../auth.service';
import { StorageService } from '../../storage/storage.service';

@Component({
  selector: 'app-superadminlogin',
  templateUrl: './superadminlogin.component.html',
  styleUrl: './superadminlogin.component.css'
})
export class SuperadminloginComponent {
  constructor(private service:AuthService,private router:Router,private storage:StorageService){

  }
  form:FormGroup=new FormGroup({
    email:new FormControl(''),
    password:new FormControl('')
  })

  formSubmit(){
    console.log(this.form.value);

    this.service.login(this.form.value).subscribe(res=>{
      if(res!=null){
        this.storage.saveuser(res);
        let user = this.storage.getuser();
        if(user!==null){
          this.router.navigate(["/admin-home"]);
        }
        else{
          this.router.navigate(["/"]);
        }
      }
      else{
        alert("invalid user");
      }

      console.log(res);
    },err=>{
      console.log(err);
    }
  )
  }

}
