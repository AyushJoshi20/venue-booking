import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { VenuesComponent } from './components/venues/venues.component';
import { authGuard } from './auth.guard';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {path:'',component:HomeComponent},
    {path:'venues',component:VenuesComponent,canActivate:[authGuard]},
    {path:'login',component:LoginComponent},
    {path:'signup',component:SignupComponent}
];
