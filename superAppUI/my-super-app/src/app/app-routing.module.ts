import { RouterModule, Routes } from '@angular/router';
import { UserDetailsComponent } from './user-details/user-details.component';
import { NgModule } from '@angular/core';
import { UserListComponent } from './user-list/user-list.component';

export const routes: Routes = [
    {path: 'users', component: UserListComponent},
    {path: 'users/:id', component: UserDetailsComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
