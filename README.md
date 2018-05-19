# units
A generic library of world units.

Work in progress since Oct 2017. Fully functional but not ready for use in production.

Use at own risk, contribute at own heart.

Quick example:

```
Length distance = new Meters(10, Magnitude.KILO);
Time duration = new Hours(2);
Speed speed = distance.dividedBy(duration, MathContext.DECIMAL64);

System.out.println(speed.getAmount() + " " + speed.getUnit());
```
> 5000 m⋅h⁻¹