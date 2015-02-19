import wblut.math.*;
import wblut.processing.*;
import wblut.hemesh.*;
import wblut.geom.*;

HE_Mesh mesh;
WB_Render3D render;

void setup() {
  size(800, 800, P3D);
  smooth(8);
  HEC_Dodecahedron creator=new HEC_Dodecahedron();
  creator.setEdge(160); 
  mesh=new HE_Mesh(creator); 

  mesh.modify( new HEM_ChamferEdges().setDistance(25));
  mesh.triSplitFaces();
  mesh.midEdgeSplitFaces();
  mesh.midEdgeSplitFaces();
  mesh.triangulate();
  HE_FaceIterator fitr=new HE_FaceIterator(mesh);
  colorMode(HSB);
  while (fitr.hasNext ()) {
    fitr.next().setColor(color((int)random(4.0)*10, 255, 255));
  }

  HE_VertexIterator vitr=new HE_VertexIterator(mesh);
  colorMode(HSB);
  while (vitr.hasNext ()) {
    vitr.next().setColor(color((int)random(4.0)*10, 255, 255));
  }
  colorMode(RGB);
  HET_Export.saveToWRLWithFaceColor(mesh, sketchPath,"testfc.wrl");
  HET_Export.saveToWRLWithVertexColor(mesh, sketchPath,"testvc.wrl");
  HET_Export.saveToWRL(mesh, sketchPath,"test.wrl");
  HET_Export.saveToPLY(mesh, sketchPath,"test.ply");
  HET_Export.saveToOBJ(mesh, sketchPath,"test");
  HET_Export.saveToOBJWithFaceColor(mesh, sketchPath,"testfc");
  HET_Export.saveToOBJWithVertexColor(mesh, sketchPath,"testvc");
  HET_Export.saveToPLYWithVertexColor(mesh, sketchPath,"testvc.ply");
  HET_Export.saveToPLYWithFaceColor(mesh, sketchPath,"testfc.ply");
  render=new WB_Render3D(this);
}

void draw() {
  background(60);
  directionalLight(255, 255, 255, 1, 1, -1);
  directionalLight(127, 127, 127, -1, -1, 1);
  translate(400, 400, 100);
  rotateY(mouseX*1.0f/width*TWO_PI);
  rotateX(mouseY*1.0f/height*TWO_PI);
  stroke(0);
  render.drawEdges(mesh);
  noStroke();
  render.drawFacesVC(mesh);
}

