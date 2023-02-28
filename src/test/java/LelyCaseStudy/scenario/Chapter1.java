package LelyCaseStudy.scenario;

import LelyCaseStudy.RestAssured.RestAssuredBase;
import org.testng.annotations.Test;


public class Chapter1 extends RestAssuredBase {
    @Test
    public void step1(){
        LogResponseBody();
        ChechDataid4Digit();
    }

    @Test
    public void step2(){
        PostReq();
    }
    @Test
    public void step3(){
        CheckAlreadyBeTaken();
    }
}
