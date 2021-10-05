# units

A generic library of world units for type-safe calculation of amounts.

Work in progress since Oct 2017. Fully functional but not ready for use in production.

Use at own risk, contribute at own heart.

Quick example:

```
Length distance = new Meters(10, Magnitude.KILO);
Time duration = new Hours(2);
Speed speed = distance.div(duration, MathContext.UNLIMITED);
Pace pace = duration.div(distance, MathContext.UNLIMITED);

System.out.println(speed.getAmount() + " " + speed.getUnit());
System.out.println(pace.getAmount() + " " + pace.getUnit());
```

> 5000 h⁻¹⋅m

> 0.0002 h⋅m⁻¹

Soon to be:

```
 Length distance = new Meters(10, Magnitude.KILO);
 Time duration = new Hours(2);
 Speed speed = distance.div(duration);
 Pace pace = duration.div(distance);
 
 System.out.println(speed.getAmount(MathContext.UNLIMITED) + " " + speed.getUnit());
 System.out.println(pace.getAmount(MathContext.UNLIMITED) + " " + pace.getUnit());
```
