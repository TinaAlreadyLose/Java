function d = v_disteusq(x,y,mode,w)
[nx,p]=size(x); ny=size(y,1);
if nargin<3 | isempty(mode)
    mode='0';
end
if any(mode=='d') | (mode~='x' & nx==ny)
 
    % Do pairwise distance calculation

    nx=min(nx,ny);
    z=double(x(1:nx,:))-double(y(1:nx,:));
    if nargin<4
        d=sum(z.*conj(z),2);
    elseif min(size(w))==1
        wv=w(:).';
        d=sum(z.*wv(ones(size(z,1),1),:).*conj(z),2);
    else
        d=sum(z*w.*conj(z),2);
    end
else
    
    % Calculate full distance matrix
    
    if p>1
        
        % x and y are matrices
        
        if nargin<4
            z=permute(double(x(:,:,ones(1,ny))),[1 3               2])-permute(double(y(:,:,ones(1,nx))),[3 1 2]);
            d=sum(z.*conj(z),3);
        else
            nxy=nx*ny;
            z=reshape(permute(double(x(:,:,ones(1,ny))),[1 3 2])-permute(double(y(:,:,ones(1,nx))),[3 1 2]),nxy,p);
            if min(size(w))==1
                wv=w(:).';
                d=reshape(sum(z.*wv(ones(nxy,1),:).*conj(z),2),nx,ny);
            else
                d=reshape(sum(z*w.*conj(z),2),nx,ny);
            end
        end
    else
        
        % x and y are vectors
        
        z=double(x(:,ones(1,ny)))-double(y(:,ones(1,nx))).';
        if nargin<4
            d=z.*conj(z);
        else
            d=w*z.*conj(z);
        end
    end
end
if any(mode=='s')
    d=sqrt(d);
end
end

