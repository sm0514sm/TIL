## 회원 웹 기능 - 홈 화면 추가

```java
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

```

-   다른 컨트롤러에 존재하는 도메인 (ex: "hello")과 같은 게 있으면 에러발생
-   `resources/static/index.html`은 Controller에서 (`"/"`)가 없는 경우, 보여짐
-   즉, 컨트롤러가 정적 파일보다 우선순위가 높다.

<br>

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <div><h1>Hello Spring</h1>
        <p>회원 기능</p>
        <p>
            <a href="/members/new">회원 가입</a>
            <a href="/members">회원 목록</a>
        </p></div>
</div> <!-- /container -->
</body>
</html>
```

<br>

## 회원 웹 기능 - 등록

```java
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
}
```



`members/createMemberForm`

-   name="name" 여기서 "name"이 Controller의 `MemberForm form`매개변수 객체의 필드로 들어감

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <form action="/members/new" method="post">
        <div class="form-group"><label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
        </div>
        <button type="submit">등록</button>
    </form>
</div> <!-- /container -->
</body>
</html>
```

<br>

## 회원 웹 기능 - 조회

`MemberController.java`

```java
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
```

-   members를 key값으로 members 객체 전달

`members/memberList.html`

```html
            <tr th:each="member : ${members}">
                <td th:text="${member.id}"></td>
                <td th:text="${member.name}"></td>
            </tr>
```

-   member의 `getId()`, `getName()`으로부터 값을 가져옴

