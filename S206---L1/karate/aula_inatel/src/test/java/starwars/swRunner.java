package starwars;

import com.intuit.karate.junit5.Karate;

class swRunner {
    
    @Karate.Test
    Karate testStarWars() {
        return Karate.run("starwars").relativeTo(getClass());
    }    

}