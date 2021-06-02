public class Planet
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img)
	{
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p)
	{
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p)
	{
		double xDistance = xxPos - p.xxPos;
		double yDistance = yyPos - p.yyPos;
		return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
	}

	public double calcForceExertedBy(Planet p)
	{
		double distance = calcDistance(p);
		return G*mass*p.mass/(distance*distance);
	}

	public double calcForceExertedByX(Planet p)
	{
		double totalForce = calcForceExertedBy(p);
		double xDistance = p.xxPos - xxPos;
		double distance = calcDistance(p);
		return totalForce * xDistance/distance;
		//return xDistance >= 0 ? totalForce * xDistance/distance:-(totalForce * xDistance/distance);
	}

	public double calcForceExertedByY(Planet p)
	{
		double totalForce = calcForceExertedBy(p);
		double yDistance = p.yyPos - yyPos;
		double distance = calcDistance(p);
		return totalForce * yDistance/distance;
		//return yDistance >= 0 ? totalForce * yDistance/distance:-(totalForce * yDistance/distance);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets)
	{
		int numberOfPlanets = allPlanets.length;
		double netForceExertedByX = 0;
		for(Planet p: allPlanets)
		{
			if(this.equals(p))
			{
				continue;
			}
			netForceExertedByX += calcForceExertedByX(p);
			//netForceExertedByX += (xxPos - p.xxPos)>0? calcForceExertedByX(p):-(calcForceExertedByX(p));
		}
		return netForceExertedByX;
		//return netForceExertedByX >= 0? netForceExertedByX: -netForceExertedByX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets)
	{
		int numberOfPlanets = allPlanets.length;
		double netForceExertedByY = 0;
		for(Planet p: allPlanets)
		{
			if(this.equals(p))
			{
				continue;
			}
			netForceExertedByY += calcForceExertedByY(p);
			//netForceExertedByY += (yyPos - p.yyPos)>0? calcForceExertedByY(p):-(calcForceExertedByY(p));
		}
		
		return netForceExertedByY;
		//return netForceExertedByY >= 0? netForceExertedByY: -netForceExertedByY;
	}

	public void update(double dt, double netXForce, double netYForce)
	{
		double aX = netXForce / mass;
		double aY = netYForce / mass;
		
		xxVel = xxVel + aX * dt;
  		yyVel = yyVel + aY * dt;

  		xxPos = xxPos + xxVel * dt;
  		yyPos = yyPos + yyVel * dt;

	}

	public void draw()
	{
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}


}