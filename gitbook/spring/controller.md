# controller

[Spring MVC Test 官方文档](https://docs.spring.io/spring/docs/5.1.2.RELEASE/spring-framework-reference/testing.html#spring-mvc-test-framework)







```java
@WebMvcTest
@RunWith(SpringRunner.class)
public class AccountControllerTest {
        @Autowired
        MockMvc mockMvc;
        @MockBean
        AccountService accountService;
}
```

具体思路 单元测试还是要隔离的，即隔离Service进行测试。所以Service需要@MockBean 进行注入 @MockBean用法与之前一致
                                        

```java
    @Test
    public void delete() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post(PREFIX+"/delete").param("accountId","1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

```

核心原理:通过mockMvc来构建发送请求，预期结果(包含返回内容，HTTP状态码，返回的Header等)