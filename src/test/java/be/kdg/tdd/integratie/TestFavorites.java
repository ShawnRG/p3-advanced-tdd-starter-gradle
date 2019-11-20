package be.kdg.tdd.integratie;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"../../../../../resources/testcontext.xml"})
public class TestFavorites {
/*    @Autowired
    private FavoriteService favoriteService;


    @Before
    public void setup() {
        favoriteService.addUser("root", "rootpasswd", "username", "password");
        favoriteService.addUser("root", "rootpasswd", "username2", "password2");
    }

    @After
    public void tearDown() {
        favoriteService.removeUser("root", "rootpasswd", "username", "password");
        favoriteService.removeUser("root", "rootpasswd", "username2", "password2");
    }

    @Test
    public void testGetFavoritesOfExistingUserWithoutFavorites() {
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertNotNull("getFavorites should never return null", favorites);
        assertEquals("there should be no favorites in the list", 0, favorites.size());
    }
*/


/*
    @Test
    public void testGetFavoritesOfExistingUserWithOneFavorite() {
        favoriteService.addFavorite("username", "password", "favorite1");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have 1 favorite", 1, favorites.size());
        assertEquals("favorite should be 'favorite1'", "favorite1", favorites.get(0));
        favoriteService.removeFavorite("username", "password", "favorite1");
    }
*/
/*
    @Test
    public void testRemoveFavorites() {
        favoriteService.addFavorite("username", "password", "favorite1");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have 1 favorite", 1, favorites.size());
        assertEquals("favorite should be 'favorite1'", "favorite1", favorites.get(0));
        favoriteService.removeFavorite("username", "password", "favorite1");
        favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have no favorites", 0, favorites.size());
    }
*/
/*
    @Test
    public void testGetFavoritesOfExistingUserWithTwoFavorites() {
        favoriteService.addFavorite("username", "password", "a favorite");
        favoriteService.addFavorite("username", "password", "another favorite");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have 2 favorites", 2, favorites.size());
        assertTrue("'a favorite' should have been added", favorites.contains("a favorite"));
        assertTrue("'another favorite' should have been added", favorites.contains("another favorite"));
        favoriteService.removeFavorite("username", "password", "a favorite");
        favoriteService.removeFavorite("username", "password", "another favorite");
    }
*/
/*
    @Test
    public void testRemoveOneOFManyFavorites() {
        favoriteService.addFavorite("username", "password", "favorite1");
        favoriteService.addFavorite("username", "password", "favorite2");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have 2 favorites", 2, favorites.size());
        assertEquals("favorite should be 'favorite1'", "favorite1", favorites.get(0));
        favoriteService.removeFavorite("username", "password", "favorite1");
        favorites = favoriteService.getFavorites("username", "password");
        assertEquals("user username should have 1 favorite", 1, favorites.size());
        assertEquals("favorite should be 'favorite2'", "favorite2", favorites.get(0));
        favoriteService.removeFavorite("username", "password", "favorite2");
    }
 */
/*
    @Test
    public void testGetFavoritesOfNonExistingUser() {
        favoriteService.addFavorite("username", "password", "a favorite");
        List<String> favorites = favoriteService.getFavorites("nonexsting", "wrong password");
        assertEquals("there should not be any favorites", 0, favorites.size());
        favoriteService.removeFavorite("username", "password", "a favorite");
    }
*/
/*
    @Test
    public void testGetFavoritesFromDifferentUser() {
        favoriteService.addFavorite("username", "password", "a favorite");
        favoriteService.addFavorite("username2", "password2", "another favorite");
        List<String> favorites = favoriteService.getFavorites("username2", "password2");
        assertEquals("user should have 1 favorite", 1, favorites.size());
        assertEquals("favorite should be 'another favorite'", "another favorite", favorites.get(0));
        favoriteService.removeFavorite("username", "password", "a favorite");
        favoriteService.removeFavorite("username2", "password2", "another favorite");
    }
*/
/*
    @Test
    public void testWrongCredentialsWithAddFavorite() {
        favoriteService.addFavorite("username", "wrong password", "a favorite");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("should not be able to add favorite with wrong password", 0, favorites.size());
    }
*/
/*
    @Test
    public void testWrongCredentialsWithRemoveFavorites() {
        favoriteService.addFavorite("username", "password", "a favorite");
        favoriteService.removeFavorite("username", "wrong password", "a favorite");
        List<String> favorites = favoriteService.getFavorites("username", "password");
        assertEquals("should not be able to remove favorite with wrong credentials", 1, favorites.size());
        favoriteService.removeFavorite("username", "password", "a favorite");
    }
*/
}
