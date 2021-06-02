public class NBody
{
	public static double readRadius(String filePath)
	{
		In in = new In(filePath);

		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String filePath)
	{
		In in = new In(filePath);

		int numberOfPlanets = in.readInt();
		in.readDouble();

		Planet[] allPlanets = new Planet[numberOfPlanets];

		for(int indexOfPlanet = 0; indexOfPlanet < numberOfPlanets; indexOfPlanet++)
		{
			allPlanets[indexOfPlanet] = new Planet(0,0,0,0,0,"");
			allPlanets[indexOfPlanet].xxPos = in.readDouble();
		    allPlanets[indexOfPlanet].yyPos = in.readDouble();
		    allPlanets[indexOfPlanet].xxVel = in.readDouble();
		    allPlanets[indexOfPlanet].yyVel = in.readDouble();
		    allPlanets[indexOfPlanet].mass = in.readDouble();
		    allPlanets[indexOfPlanet].imgFileName = in.readString();
		}


        return allPlanets;
	}

	public static void main(String[] args)
	{
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
   
        double universeRadius = readRadius(fileName);

        Planet[] allPlanets = readPlanets(fileName);


        StdDraw.setScale(-2.5e11,2.5e11);
        StdDraw.picture(0,0,"images/starfield.jpg");

        for(Planet p : allPlanets)
        {
        	p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double elapsedTime = 0;

        int numberOfPlanets = allPlanets.length;

        while(elapsedTime < T)
        {
            double[] xForces = new double[numberOfPlanets];
            double[] yForces = new double[numberOfPlanets];
            for(int index = 0; index < numberOfPlanets; index++)
            {
            	xForces[index] = allPlanets[index].calcNetForceExertedByX(allPlanets);
            	yForces[index] = allPlanets[index].calcNetForceExertedByY(allPlanets);

            	allPlanets[index].update(dt,xForces[index],yForces[index]);

            	StdDraw.picture(0,0,"images/starfield.jpg");
            	for(Planet p : allPlanets)
        		{
        			p.draw();
        		}

        		StdDraw.show();
			    StdDraw.pause(10);

			    elapsedTime += dt;

            }


        }





	StdOut.printf("%d\n", allPlanets.length);
	StdOut.printf("%.2e\n", universeRadius);
	for (int i = 0; i < allPlanets.length; i++) 
	{
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
    }



	}
}