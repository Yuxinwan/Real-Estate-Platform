package tcd.ie.houseplatform.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String nickName;

    @Column(nullable = false, unique = false, length = 100)
    private String content;

    @Column(nullable = false)
    private int rate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString(){
        return "Review{" +
                "id=" + id +
                ", nickname='" + nickName + '\'' +
                ", body='" + content + '\'' +
                ", rating='" + rate +
                '}';
    }
}
