package apiben10;

import com.intuit.karate.junit5.Karate;

class ben10Runner {
    
    @Karate.Test
    Karate testBen10() {
        return Karate.run("ben10").relativeTo(getClass());
    }    

}
