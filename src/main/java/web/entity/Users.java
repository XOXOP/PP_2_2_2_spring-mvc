package web.entity;


import javax.persistence.*;



@Entity
@Table(name = "users")
public class Users {
    public Users(){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "hobby")
    private boolean hobby;

    public Users(String name, String surname, boolean hobby) {
        this.name = name;
        this.surname = surname;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isHobby() {
        return hobby;
    }

    public void setHobby(boolean hobby) {
        this.hobby = hobby;
    }
}



