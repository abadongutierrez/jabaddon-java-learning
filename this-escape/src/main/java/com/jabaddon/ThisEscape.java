package com.jabaddon;

import java.util.Date;

public class ThisEscape {
   private final int num;

   public ThisEscape(EventSource source) {
      source.registerListener(
            new EventListener() {
               @Override
               public void onEvent(Event e) {
                  doSomething(e);
               }
            });
      num = 42;
   }

   private void doSomething(Event e) {
//      System.out.println("[" + this.toString() + "] num = [" + num + "]");
      if (num != 42) {
         System.out.println("Race condition detected at " + new Date());
      }
//         System.out.println("Everything is ok!");
//      }
   }
}