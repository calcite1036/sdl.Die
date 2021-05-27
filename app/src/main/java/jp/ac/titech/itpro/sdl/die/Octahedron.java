package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements Obj {

    private final static float[] VERTICES = {
            //center
            -1, 0, 0,
            0, 0, -1,
            0, 0, 1,
            1, 0, 0,

            //side
            -1, 0, 0,
            0, 0, -1,
            0, -1, 0,

            0, 0, -1,
            1, 0, 0,
            0, -1, 0,

            1, 0, 0,
            0, 0, 1,
            0, -1, 0,

            0, 0, 1,
            -1, 0, 0,
            0, -1, 0,

            -1, 0, 0,
            0, 0, -1,
            0, 1, 0,

            0, 0, -1,
            1, 0, 0,
            0, 1, 0,

            1, 0, 0,
            0, 0, 1,
            0, 1, 0,

            0, 0, 1,
            -1, 0, 0,
            0, 1, 0
    };

    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // center
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // side
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 4, 3);

        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 7, 3);

        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 10, 3);

        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 13, 3);

        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 16, 3);

        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 19, 3);

        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 22, 3);

        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 25, 3);
    }
}
