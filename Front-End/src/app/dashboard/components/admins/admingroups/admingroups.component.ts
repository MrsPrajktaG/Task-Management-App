import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admingroups',
  templateUrl: './admingroups.component.html',
  styleUrl: './admingroups.component.css'
})
export class AdmingroupsComponent implements OnInit {

  constructor(private service: AdminService, private para: ActivatedRoute){}

  permissions = [
    {
      id : "",
      showPermission : "",
      createPermission : "",
      editPermission : "",
      deletePermission : "",
      modules : ""
    }
  ]

  adminGroup = {
    id : "",
    group_name : "",
    Created_date : "",
    description : ""
  }

  form: FormGroup = new FormGroup({
    id : new FormControl(''),
    showPermission : new FormControl(''),
    createPermission : new FormControl(''),
    editPermission : new FormControl(''),
    deletePermission : new FormControl(''),
    modules :new FormControl('')
  })


  adminGroup_id: any
  ngOnInit(): void {

    this.para.paramMap.pipe().subscribe(res=>{
      this.adminGroup_id = res.get("id")
    })

    this.service.getGroupById(this.adminGroup_id).subscribe(res=>{
      if(res!==null){
        this.adminGroup = res;
      }
    })

    this.service.getAllPermissionsById(this.adminGroup_id).subscribe(res=>{
      if(res!==null){
        this.permissions = res;
      }
    },err=>{
      console.log(err);
    })
    
  }

  userPermission = {
    moduleName: "",
    permissionId: "",
    showPermission: false,
    createPermission: false,
    editPermission: false,
    deletePermission: false
  }


  formSubmit(){
    console.log(this.form.value);
  }


}


