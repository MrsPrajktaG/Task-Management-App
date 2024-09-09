import { Component } from '@angular/core';
import { AuthService } from '../../../auth/auth.service';
import { Router } from '@angular/router';
import { StorageService } from '../../../auth/storage/storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  constructor(private service:AuthService,private router:Router,private storage:StorageService){}
  logoutFrom(){
    this.storage.logout();
    this.router.navigate(['/'])
  }

}
