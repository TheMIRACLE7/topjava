package ru.javawebinar.topjava.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractUserMealServiceTest;

@ActiveProfiles(Profiles.JDBC)
public class JdbcUserMealServiceTest extends AbstractUserMealServiceTest {
}