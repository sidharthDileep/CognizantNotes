import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { UserDetailsComponent } from "./user-details/user-details.component";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { UserListComponent } from "./user-list/user-list.component";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations: [
        AppComponent,
        UserDetailsComponent,
        UserListComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        CommonModule,
        FormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
}) export class AppModule { }