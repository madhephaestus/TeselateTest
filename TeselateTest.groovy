import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.Hexagon

// code here

//List<CSG> tesselate(CSG incoming,int xSteps, int ySteps, int zSteps, double xGrid, double yGrid, double zGrid, double oddRowXOffset, double oddColYOffset, double oddLayZOffset){
//		ArrayList<CSG> back = new ArrayList<CSG>();
//		for(int i=0;i<xSteps;i++) {
//			for(int j=0;j<ySteps;j++) {
//				for(int k=0;k<zSteps;k++) {
//					double xoff = i%2==0?0:oddRowXOffset;
//					double yoff = j%2==0?0:oddColYOffset;
//					double zoff = k%2==0?0:oddLayZOffset;
//					back.add(incoming.move(xoff+(((double)i)*xGrid),yoff+(((double)j)*yGrid), zoff+(((double)k)*zGrid)));
//				}
//			}
//		}
//		return back;
//	}

//List<CSG> tesselate(CSG incoming, int xSteps, int ySteps, int zSteps, double xGrid, double yGrid, double zGrid, double[][] offsets) {
//	ArrayList<CSG> back = new ArrayList<CSG>();
//	for (int i = 0; i < xSteps; i++) {
//		for (int j = 0; j < ySteps; j++) {
//			for (int k = 0; k < zSteps; k++) {
//				double xoff = offsets[0][(i % 2 == 0) ? 0 : 1];
//				double yoff = offsets[1][(j % 2 == 0) ? 0 : 1];
//				double zoff = offsets[2][(k % 2 == 0) ? 0 : 1];
//				back.add(incoming.move(xoff + (i * xGrid), yoff + (j * yGrid), zoff + (k * zGrid)));
//			}
//		}
//	}
//	return back;
//}

//List<CSG> tesselate(CSG incoming, int xSteps, int ySteps, int zSteps, double xGrid, double yGrid, double zGrid, double[][] offsets) {
//	ArrayList<CSG> back = new ArrayList<CSG>();
//	for (int i = 0; i < xSteps; i++) {
//		for (int j = 0; j < ySteps; j++) {
//			for (int k = 0; k < zSteps; k++) {
//				double xoff = offsets[0][(i % 3)];
//				double yoff = offsets[1][(j % 3)];
//				double zoff = offsets[2][(k % 3)];
//				back.add(incoming.move(xoff + (i * xGrid), yoff + (j * yGrid), zoff + (k * zGrid)));
//			}
//		}
//	}
//	return back;
//}

List<CSG> tesselate(CSG incoming, int xSteps, int ySteps, int zSteps, double xGrid, double yGrid, double zGrid, double[][] offsets) {
	double oddRowXOffset = offsets[0][0];
	double oddRowYOffset = offsets[0][1];
	double oddRowZOffset = offsets[0][2];

	double oddColXOffset = offsets[1][0];
	double oddColYOffset = offsets[1][1];
	double oddColZOffset = offsets[1][2];

	double oddLayXOffset = offsets[2][0];
	double oddLayYOffset = offsets[2][1];
	double oddLayZOffset = offsets[2][2];

	ArrayList<CSG> back = new ArrayList<CSG>();
	for (int i = 0; i < xSteps; i++) {
		for (int j = 0; j < ySteps; j++) {
			for (int k = 0; k < zSteps; k++) {

                double xoff = 0;
                double yoff = 0;
                double zoff = 0;

                if (i % 2 != 0) {
                    xoff += oddRowXOffset;
                    yoff += oddRowYOffset;
                    zoff += oddRowZOffset;
                }

                if (j % 2 != 0) {
                    xoff += oddColXOffset;
                    yoff += oddColYOffset;
                    zoff += oddColZOffset;
                }

                if (k % 2 != 0) {
                    xoff += oddLayXOffset;
                    yoff += oddLayYOffset;
                    zoff += oddLayZOffset;
                }

				back.add(incoming.move(xoff + (i * xGrid), yoff + (j * yGrid), zoff + (k * zGrid)));
			}
		}
	}
	return back;
}

double[][] zeroMatrix = [ [0,0,0], [0,0,0], [0,0,0] ]
double[][] offsetMatrix = [ [0,0,0], [0,0,0], [4,4,0] ]
return tesselate(new Sphere(3).toCSG(),3,3,3,8,8,4,offsetMatrix)
