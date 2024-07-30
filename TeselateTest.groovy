import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.Hexagon

// code here

List<CSG> tesselate(CSG incoming,int xSteps, int ySteps, int zSteps, double xGrid, double yGrid, double zGrid, double oddRowXOffset, double oddColYOffset, double oddLayZOffset){
		ArrayList<CSG> back = new ArrayList<CSG>();
		for(int i=0;i<xSteps;i++) {
			for(int j=0;j<ySteps;j++) {
				for(int k=0;k<zSteps;k++) {
					double xoff = i%2==0?0:oddRowXOffset;
					double yoff = j%2==0?0:oddColYOffset;
					double zoff = k%2==0?0:oddLayZOffset;
					back.add(incoming.move(xoff+(((double)i)*xGrid),yoff+(((double)j)*yGrid), zoff+(((double)k)*zGrid)));
				}
			}
		}
		return back;
	}

return tesselate(new Sphere(3).toCSG(),5,5,3,10,10,10,0,0,0)