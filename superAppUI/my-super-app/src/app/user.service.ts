import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "./user";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private baseUrl = 'http:// localhost:8080/api/v1/users';

    constructor(private http: HttpClient){}

    getUsers(): Observable<User[]>{
        return this.http.get<User[]>(`${this.baseUrl}`);
    }

    getUser(id: number): Observable<User> {
        return this.http.get<User>(`${this.baseUrl}/${id}`)
    }

    createUser(user: User): Observable<User> {
        return this.http.post<User>(this.baseUrl, user);
    }

    updateUser(id: number, user: User): Observable<User>{
        return this.http.put<User>(`${this.baseUrl}/{id}`, user);
    }

    deleteUser(id: number): Observable<void> {
        return this.http.delete<void>(`${this.baseUrl}/${id}`);
    }
}