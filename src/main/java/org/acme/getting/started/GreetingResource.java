package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

@Path("/hello")
public class GreetingResource {


  private static final UserAgentAnalyzer uaa = UserAgentAnalyzer
      .newBuilder()
      .hideMatcherLoadStats()
      .withCache(10000)
      .build();

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    UserAgent agent = uaa.parse(
        "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11");
    return agent.getValue(UserAgent.DEVICE_CLASS);
  }
}