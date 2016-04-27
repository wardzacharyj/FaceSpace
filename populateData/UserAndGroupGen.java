// package com.company;

/**
 * Created by xiaokaiwang on 4/15/16.
 */
//STEP 1. Import required packages
import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
public class UserAndGroupGen {
    // JDBC driver name and database URL

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";
    // Local DB test:
    //private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:dbclass";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String USER = sc.nextLine();
        System.out.println("Please enter your password: ");
        String PASS = sc.nextLine();

        String str = "insert into UserTable (email, firstName, lastName, birthday) values ('tlawson0@dailymotion.com', 'Timothy', 'Lawson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('djames1@state.tx.us', 'Debra', 'James', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jmurphy2@ucoz.ru', 'Joan', 'Murphy', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dhenderson3@springer.com', 'Diane', 'Henderson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rcook4@tripadvisor.com', 'Ruby', 'Cook', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('fford5@senate.gov', 'Fred', 'Ford', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sday6@ovh.net', 'Stephen', 'Day', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('klawrence7@nba.com', 'Kelly', 'Lawrence', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dsanchez8@sogou.com', 'Douglas', 'Sanchez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rspencer9@so-net.ne.jp', 'Ryan', 'Spencer', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lkelleya@parallels.com', 'Lori', 'Kelley', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rmccoyb@mapquest.com', 'Robert', 'Mccoy', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rstewartc@cdc.gov', 'Roy', 'Stewart', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tfreemand@gnu.org', 'Tammy', 'Freeman', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('aberrye@weebly.com', 'Angela', 'Berry', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('drogersf@sogou.com', 'Dennis', 'Rogers', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('knelsong@ucsd.edu', 'Kathryn', 'Nelson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jlaneh@cyberchimps.com', 'Jacqueline', 'Lane', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('svasquezi@redcross.org', 'Stephanie', 'Vasquez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('freidj@sun.com', 'Fred', 'Reid', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tmartinezk@webs.com', 'Tina', 'Martinez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('smartinezl@so-net.ne.jp', 'Stephanie', 'Martinez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('cmarshallm@is.gd', 'Carl', 'Marshall', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('ldiazn@ca.gov', 'Lisa', 'Diaz', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mlyncho@ed.gov', 'Margaret', 'Lynch', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('agreenp@unesco.org', 'Andrea', 'Green', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bkelleyq@reddit.com', 'Brian', 'Kelley', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mnicholsr@prweb.com', 'Michelle', 'Nichols', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rrobertss@qq.com', 'Rachel', 'Roberts', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dcartert@about.me', 'Daniel', 'Carter', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('efergusonu@huffingtonpost.com', 'Elizabeth', 'Ferguson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('greyesv@usa.gov', 'Gary', 'Reyes', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('pharperw@arizona.edu', 'Pamela', 'Harper', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('kcolex@ft.com', 'Kelly', 'Cole', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('srosey@hao123.com', 'Sandra', 'Rose', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jparkerz@ezinearticles.com', 'Janice', 'Parker', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('llane10@usda.gov', 'Lillian', 'Lane', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jrichardson11@china.com.cn', 'Joshua', 'Richardson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jhanson12@yellowbook.com', 'Jacqueline', 'Hanson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mcole13@omniture.com', 'Mark', 'Cole', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('kdunn14@independent.co.uk', 'Karen', 'Dunn', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('estevens15@indiegogo.com', 'Edward', 'Stevens', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jtaylor16@github.io', 'Jason', 'Taylor', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('psims17@guardian.co.uk', 'Patricia', 'Sims', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rdunn18@nyu.edu', 'Roger', 'Dunn', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('phall19@ted.com', 'Patrick', 'Hall', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('acampbell1a@wisc.edu', 'Anne', 'Campbell', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dlawrence1b@si.edu', 'Daniel', 'Lawrence', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('arodriguez1c@diigo.com', 'Anne', 'Rodriguez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jrichardson1d@spiegel.de', 'Jose', 'Richardson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('fcampbell1e@home.pl', 'Frances', 'Campbell', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('wdavis1f@miibeian.gov.cn', 'Wayne', 'Davis', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lrobertson1g@weather.com', 'Linda', 'Robertson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('cwheeler1h@cnet.com', 'Carol', 'Wheeler', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bhunter1i@reddit.com', 'Betty', 'Hunter', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('hford1j@census.gov', 'Harold', 'Ford', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lwells1k@eepurl.com', 'Lillian', 'Wells', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('grose1l@tiny.cc', 'Gloria', 'Rose', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sscott1m@nasa.gov', 'Sara', 'Scott', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('wbutler1n@linkedin.com', 'Willie', 'Butler', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jcampbell1o@marriott.com', 'Jacqueline', 'Campbell', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('amorrison1p@ovh.net', 'Aaron', 'Morrison', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('gvasquez1q@goo.ne.jp', 'Gloria', 'Vasquez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lgilbert1r@freewebs.com', 'Lawrence', 'Gilbert', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('vrose1s@cloudflare.com', 'Victor', 'Rose', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bmedina1t@si.edu', 'Bobby', 'Medina', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('afuller1u@netvibes.com', 'Albert', 'Fuller', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mrice1v@about.com', 'Mildred', 'Rice', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sweaver1w@google.it', 'Sara', 'Weaver', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jgeorge1x@smh.com.au', 'Janice', 'George', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('asanders1y@bloomberg.com', 'Albert', 'Sanders', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tking1z@live.com', 'Tammy', 'King', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dmontgomery20@upenn.edu', 'Dorothy', 'Montgomery', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sgonzalez21@youtu.be', 'Shawn', 'Gonzalez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('amurphy22@webeden.co.uk', 'Antonio', 'Murphy', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tfranklin23@netwosing.org', 'Tammy', 'Franklin', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('amendoza24@wix.com', 'Alan', 'Mendoza', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mprice25@xrea.com', 'Marie', 'Price', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('fharper26@unblog.fr', 'Fred', 'Harper', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jalexander27@i2i.jp', 'Jimmy', 'Alexander', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jmcdonald28@google.cn', 'Jacqueline', 'Mcdonald', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('cgraham29@plala.or.jp', 'Catherine', 'Graham', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('aburke2a@pagesperso-orange.fr', 'Amy', 'Burke', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sshaw2b@forbes.com', 'Susan', 'Shaw', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dreid2c@nhs.uk', 'Douglas', 'Reid', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sortiz2d@bing.com', 'Scott', 'Ortiz', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jwatkins2e@jigsy.com', 'James', 'Watkins', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('along2f@techcrunch.com', 'Amanda', 'Long', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('awashington2g@craigslist.org', 'Anne', 'Washington', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('afrazier2h@ebay.com', 'Alan', 'Frazier', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('aanderson2i@psu.edu', 'Albert', 'Anderson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('djames2j@google.it', 'Donna', 'James', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('drobertson2k@ifeng.com', 'Debra', 'Robertson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dtaylor2l@ebay.co.uk', 'Daniel', 'Taylor', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bmiller2m@columbia.edu', 'Barbara', 'Miller', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lcole2n@eepurl.com', 'Louis', 'Cole', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mbanks2o@google.fr', 'Marie', 'Banks', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lallen2p@prnewswire.com', 'Lillian', 'Allen', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bwason2q@ezinearticles.com', 'Bruce', 'Washington', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('eharrison2r@sbwire.com', 'Elizabeth', 'Harrison', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('vkennedy2s@engadget.com', 'Victor', 'Kennedy', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dlittle2t@de.vu', 'Dennis', 'Little', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('acastillo2u@infoseek.co.jp', 'Alan', 'Castillo', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('vjackson2v@slideshare.net', 'Victor', 'Jackson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('acunningham2w@home.pl', 'Aaron', 'Cunningham', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('adixon2x@usda.gov', 'Ashley', 'Dixon', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('vcarpenter2y@upenn.edu', 'Victor', 'Carpenter', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('wrichardson2z@a8.net', 'Wayne', 'Richardson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jfisher30@apache.org', 'Jacqueline', 'Fisher', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('wschmidt31@drupal.org', 'Willie', 'Schmidt', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('aclark32@bizjournals.com', 'Amy', 'Clark', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('ebrown33@friendfeed.com', 'Elizabeth', 'Brown', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('aprice34@furl.net', 'Amy', 'Price', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('wpeterson35@chron.com', 'Wayne', 'Peterson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('pross36@themeforest.net', 'Pamela', 'Ross', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('lfranklin37@japanpost.jp', 'Lori', 'Franklin', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('cboyd38@bigcartel.com', 'Catherine', 'Boyd', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('koliver39@shop-pro.jp', 'Kenneth', 'Oliver', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mfuller3a@opensource.org', 'Michael', 'Fuller', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('kperez3b@wiley.com', 'Karen', 'Perez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('shansen3c@auda.org.au', 'Sean', 'Hansen', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dvasquez3d@columbia.edu', 'Deborah', 'Vasquez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dfowler3e@webs.com', 'Dennis', 'Fowler', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jperkins3f@jiathis.com', 'Jason', 'Perkins', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('ekelley3g@google.co.uk', 'Elizabeth', 'Kelley', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bcole3h@prlog.org', 'Beverly', 'Cole', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jsmith3i@blogs.com', 'Jason', 'Smith', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('drobertson3j@guardian.co.uk', 'Debra', 'Robertson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jsimmons3k@simplemachines.org', 'Janice', 'Simmons', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('kallen3l@pagesperso-orange.fr', 'Kenneth', 'Allen', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mwilson3m@instagram.com', 'Mary', 'Wilson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('ariley3n@ebay.co.uk', 'Antonio', 'Riley', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('mhughes3o@unesco.org', 'Mark', 'Hughes', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('vprice3p@bloomberg.com', 'Victor', 'Price', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('iwells3q@paginegialle.it', 'Irene', 'Wells', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('award3r@amazon.co.uk', 'Amy', 'Ward', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tjohnston3s@yellowpages.com', 'Tammy', 'Johnston', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('dperez3t@time.com', 'Diana', 'Perez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rnelson3u@bloglines.com', 'Ruby', 'Nelson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('tgraham3v@amazon.co.jp', 'Timothy', 'Graham', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sbell3w@wikispaces.com', 'Sharon', 'Bell', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('rbanks3x@1und1.de', 'Ralph', 'Banks', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('hpowell3y@reuters.com', 'Howard', 'Powell', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('twarren3z@com.com', 'Tammy', 'Warren', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('randrews40@reuters.com', 'Russell', 'Andrews', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('manderson41@ehow.com', 'Michelle', 'Anderson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('gsanchez42@meetup.com', 'Gerald', 'Sanchez', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('sgonzales43@xinhuanet.com', 'Shirley', 'Gonzales', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('jhill44@china.com.cn', 'James', 'Hill', TO_DATE('1993-01-01', 'YYYY-mm-dd'));" +
                "insert into UserTable (email, firstName, lastName, birthday) values ('bhudson45@clickbank.net', 'Betty', 'Hudson', TO_DATE('1993-01-01', 'YYYY-mm-dd'));";

        String[] arr = str.split(";");
        String str2 = "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (1,'Nulla Corporation','NC',15);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (2,'Mi Fringilla Mi Associates','MFMA',20);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (3,'Sem Pellentesque Ut Company','SPUC',30);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (4,'Ut Lacus Foundation','ULF',40);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (5,'Metus Sit Inc.','MSI',30);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (6,'Velit Institute','2vvvsss',20);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (7,'Tellus Eu Augue Industries','TEAI',30);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (8,'Purus Associates','PRA',20);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (9,'Ac Turpis Egestas Company','ATE',5);" +
                "INSERT INTO GroupTable (groupID,name,description,mLimit) VALUES (10,'Eleifend Nec Malesuada Company','ENM',30);";
        String[] arr2 = str2.split(";");
        try{



            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            for (int i =0;i< arr.length; i++){
                String sql = arr[i];

              // stmt.executeUpdate(sql);
                System.out.println(sql+";");

            }

            for (int j = 0;j < arr2.length; j++){
                String sql2 = arr2[j];

                 System.out.println(sql2+";");
             //   stmt.executeUpdate(sql2);
            }



            System.out.println("Finishing...");

            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }

}
