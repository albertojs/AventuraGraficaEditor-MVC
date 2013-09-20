package lige.grupo18.pr5.editor;
/**
 * Tipo Enumerado que contiene las 4 posibles direcciones de la brujula
 * @version 2.0
 * @author grupo18
 *
 */
	public enum Directions{
		NORTE,
		SUR,
		ESTE,
		OESTE,
		NONE;
		
		/**
		 * Metodo que devuelve la posicion opuesta a la que se está
		 * @return Devuelve el tipo enumerado opuesto
		 */
		public Directions opposite(){
			switch (this){
				case NORTE:
					return SUR;
				case SUR:
					return NORTE;
				case ESTE:
					return OESTE;
				case OESTE:
					return ESTE;
				default:
					return NONE;
			}	
		}
		
	}

