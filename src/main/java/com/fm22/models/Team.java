package com.fm22.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team extends PanacheEntity {
    @NotNull
    @Column(name = "team_name")
    private String teamName;
    @OneToMany
    private Set<Players> players;
}







//class Document{
//
//    public static void main(String[] args) {
//
//        String s = "glory";
//        System.out.println(reverseStr(s));
//    }
//
//     public static Stack<Character> reverseStr(String s){
//
//       Stack<Character> data = new Stack<>();
//
//       for(int i = s.length()-1; i >= 0; i--){
//         data.push(s.charAt(i));
//       }
//       return data;
//
//     }
//}
