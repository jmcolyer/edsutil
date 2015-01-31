package ch.rasc.edsutil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ParseException;
import static org.fest.assertions.api.Assertions.assertThat;

public class PropertyComparatorTest {

	private List<User> users;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	
	@Before
	public void setup() {
		users = new ArrayList<>();
		user1 = new User(1, "Ralph", LocalDate.of(1989, 1, 23),
				new BigDecimal("100.05"));
		users.add(user1);
		user3 = new User(3, "Lamar", LocalDate.of(1989, 2, 15),
				new BigDecimal("100.15"));
		users.add(user3);
		user2 = new User(2, "jeremy", LocalDate.of(1989, 1, 22), new BigDecimal(
				"100.25"));
		users.add(user2);
		user5 = new User(5, "Peter", LocalDate.of(1989, 12, 12),
				new BigDecimal("99.25"));
		users.add(user5);
		user4 = new User(4, "Branden", LocalDate.of(1989, 6, 7),
				new BigDecimal("99.15"));
		users.add(user4);
	}

	@Test(expected=ParseException.class)
	public void testThrowException() {
		@SuppressWarnings("unused")
		PropertyComparator<String> pc = new PropertyComparator<>("....");
	}
	
	@Test
	public void testSortLong() {
		PropertyComparator<User> pc = new PropertyComparator<>("id");
		users.sort(pc);		
		assertThat(users).containsExactly(user1, user2, user3, user4, user5);
	}

	@Test
	public void testSortString() {
		PropertyComparator<User> pc = new PropertyComparator<>("name");
		users.sort(pc);		
		assertThat(users).containsExactly(user4, user3, user5, user1, user2);
		
		pc = new PropertyComparator<>("name", true);
		users.sort(pc);		
		assertThat(users).containsExactly(user4, user2, user3, user5, user1);
	}
	
	@Test
	public void testSortBigDecimal() {
		PropertyComparator<User> pc = new PropertyComparator<>("salary");
		users.sort(pc);		
		assertThat(users).containsExactly(user4, user5, user1, user3, user2);
	}	
	
	@Test
	public void testSortLocalDate() {
		PropertyComparator<User> pc = new PropertyComparator<>("dayOfBirth");
		users.sort(pc);		
		assertThat(users).containsExactly(user2, user1, user3, user4, user5);
	}	
			
}
