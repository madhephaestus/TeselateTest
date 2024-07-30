import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.Hexagon

// code here
List<CSG> tesselateHex(CSG incoming,int xSteps, int ySteps, double spacing){
		double y= incoming.getTotalY()+spacing
		double x =(((y/Math.sqrt(3))))*3/2
		return tesselate(incoming,xSteps,ySteps,x,y,y/2);
	}
List<CSG> tesselate(CSG incoming,int xSteps, int ySteps, double oddRowYOffset){
		return tesselate(incoming,xSteps,ySteps,incoming.getTotalX(),incoming.getTotalY(),oddRowYOffset);
	}
List<CSG> tesselate(CSG incoming,int xSteps, int ySteps, double xGrid, double yGrid, double oddRowYOffset){
		ArrayList<CSG> back = new ArrayList<CSG>();
		for(int i=0;i<xSteps;i++) {
			for(int j=0;j<ySteps;j++) {
				double yoff = i%2==0?0:oddRowYOffset;
				back.add(incoming.move(((double)i)*xGrid,yoff+(((double)j)*yGrid), 0));
			}
		}
		return back;
	}

//return tesselate(new Hexagon(9,10).toCSG(),5,5,8.75,10,5)
return tesselateHex(new Hexagon(9,10).toCSG(),5,5,3)