package fr.ecole3il.rodez2023.perlin.math;


import fr.ecole3il.rodez2023.perlin.Utils;

/**
 * @author philibert roquart, fainéant
 */
public class BruitPerlin2D extends Bruit2D {

	// Vecteurs de gradient pour le bruit de Perlin
	private static final double[][] GRADIENT_2D = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 0 }, { -1, 0 },
			{ 0, 1 }, { 0, -1 } };

	// Tableau de permutations pour le bruit de Perlin
	private static final int[] PERMUTATION = { 151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225,
			140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94,
			252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74,
			165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41,
			55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169,
			200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5,
			202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183,
			170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98,
			108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12,
			191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204,
			176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195,
			78, 66, 215, 61, 156, 180 };

	private final int[] permutation;

	public BruitPerlin2D(long graine, double resolution) {
		super(graine, resolution);
		this.permutation = Utils.melanger(PERMUTATION, graine);
	}

	@Override
	public double bruit2D(double x, double y) {
		// Adapter pour la résolution
		x /= getResolution();
		y /= getResolution();

		// Obtenir les coordonnées de la grille associées à (x, y)
		int x0 = (int) (x);
		int y0 = (int) (y);

		// Masquage pour récupérer les indices de permutation
		int ii = x0 & 255;
		int jj = y0 & 255;

		// Récupérer les indices de gradient associés aux coins du quadrilatère
		int gi0 = permutation[ii + permutation[jj]] % 8;
		int gi1 = permutation[ii + 1 + permutation[jj]] % 8;
		int gi2 = permutation[ii + permutation[jj + 1]] % 8;
		int gi3 = permutation[ii + 1 + permutation[jj + 1]] % 8;

		// Récupérer les vecteurs de gradient et effectuer des interpolations pondérées
		double s = produitScalaire(GRADIENT_2D[gi0], x - x0, y - y0);
		double t = produitScalaire(GRADIENT_2D[gi1], x - (x0 + 1), y - y0);
		double u = produitScalaire(GRADIENT_2D[gi2], x - x0, y - (y0 + 1));
		double v = produitScalaire(GRADIENT_2D[gi3], x - (x0 + 1), y - (y0 + 1));

		// Interpolations pour lisser les valeurs obtenues
		double tmp = x - x0;
		double Cx = lissage(3 * tmp * tmp - 2 * tmp * tmp * tmp);

		double Li1 = s + Cx * (t - s);
		double Li2 = u + Cx * (v - u);

		tmp = y - y0;
		double Cy = lissage(3 * tmp * tmp - 2 * tmp * tmp * tmp);

		return Li2 + Cy * (Li2 - Li1);
	}

	private double produitScalaire(double[] vecteur, double x, double y) {
		return vecteur[0] * x + vecteur[1] * y;
	}

	private double lissage(double t) {
		// Appliquer une fonction de lissage spécifique à Perlin
		// Assurez-vous de gérer les erreurs d'arrondi avec soin ici
		return t * t * t * (t * (t * 6 - 15) + 10);
	}

	private double interpolation(double t, double a, double b) {
		// Effectuer une interpolation linéaire
		return a + t * (b - a);
	}

}
